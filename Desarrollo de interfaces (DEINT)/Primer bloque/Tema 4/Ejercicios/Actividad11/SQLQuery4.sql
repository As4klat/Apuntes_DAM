SELECT DISTINCT Person.Person.FirstName, Person.Person.LastName FROM Person.Person, HumanResources.Employee, Person.BusinessEntityAddress ,Person.StateProvince
WHERE Name IN('Florida')