SELECT Production.Product.Name, COUNT(SalesOrderDetail.ProductID)
FROM Production.Product
	JOIN Sales.SalesOrderDetail
	ON Product.ProductID = SalesOrderDetail.ProductID
GROUP BY SalesOrderDetail.ProductID, Production.Product.Name
ORDER BY COUNT(SalesOrderDetail.ProductID) DESC;