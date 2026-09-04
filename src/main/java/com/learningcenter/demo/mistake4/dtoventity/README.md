# Mistake 4: Returning JPA entities instead of DTOs

## 1. The mistake

The controller returns a persistence entity as its public response contract.

## 2. Original project source

`ParentController.createGoal` returned `Goal`; `GoalService.createGoal` returned `goalRepository.save(goal)`.

## 3. Bad code

`bad/GoalController` returns `Goal` directly, including whatever properties and relationships Jackson can serialize from that entity.

## 4. Why it is a problem

Persistence becomes the API contract; internal fields may leak; relationships can recurse; lazy loading may fail; schema refactors can silently alter responses; versioning is harder; clients receive unnecessary data.

## 5. How to reproduce it

POST a goal to `/demo/bad/entity/children/1/goals` and inspect the entity-shaped response (or lazy-serialization failure), including exposure pressure from `internalNotes`, `child`, and `subject`.

## 6. Bad output

The response is coupled to `Goal` and its nested entities rather than a deliberate API promise. With Open EntityManager in View disabled, lazy relationships can also make serialization fail.

## 7. Good code

`GoalResponse` lists five promised fields. The service saves the entity and explicitly maps it to that DTO before returning.

## 8. Good output

`{"goalId":41,"childId":1,"subjectId":1,"subjectName":"Mathematics","title":"Improve multiplication skills"}` with no `internalNotes`, `child`, or `subject` object.

## 9. What changed

The good controller returns `GoalResponse`; the good service owns mapping. Persistence and endpoint behavior otherwise stay focused on the same create-goal flow.

## 10. Conference talking points

DTOs make field selection, privacy, evolution, and API versioning deliberate. Mapping has a cost, but it buys an explicit boundary where that stability matters.

## 11. One-sentence takeaway

> Entities describe how data is stored. DTOs describe what the API promises to return.

