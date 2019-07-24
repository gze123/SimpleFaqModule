# SimpleFaqModule
Simple FAQ module without user identification. (Gradle + Angular 6 + Spring Boot + Hibernate)

User can decide to setup the FAQ module as administrator or view the FAQ module as a normal user.

Administrator privilege:
-CRUD access to categories,questions and answer.

User privilege:
-Create question and view all categories, questions and answer.

Relationship:
Each category can has many questions. Each question has one category.
Each question has one answer. Each answer has one question.
