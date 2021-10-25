SELECT DISTINCT Person.Person.FirstName, SUM(Sales.SalesPersonQuotaHistory.SalesQuota), YEAR(SalesPersonQuotaHistory.QuotaDate) 
/*FROM Person.Person, Sales.SalesPersonQuotaHistory
GROUP BY Person.Person.FirstName, YEAR(SalesPersonQuotaHistory.QuotaDate)
ORDER BY YEAR(SalesPersonQuotaHistory.QuotaDate)*/
FROM Person.Person
	JOIN Sales.SalesPersonQuotaHistory
	ON Person.BusinessEntityID = Sales.SalesPersonQuotaHistory.BusinessEntityID
GROUP BY Person.Person.FirstName, YEAR(SalesPersonQuotaHistory.QuotaDate)
ORDER BY YEAR(SalesPersonQuotaHistory.QuotaDate)