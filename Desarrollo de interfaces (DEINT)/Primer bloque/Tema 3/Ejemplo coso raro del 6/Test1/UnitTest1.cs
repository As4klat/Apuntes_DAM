using Actividad06;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Test1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestSuma()
        {
            List<int> valores = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            int resultado = Linq.sumaLinq(valores);
            Assert.AreEqual(45, resultado);
        }

        [TestMethod]
        public void TestPares()
        {
            List<int> valores = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            List<int> resultado = Linq.numerosParesLinq(valores);
            List<int> valoresFinales = new List<int> { 2, 4, 6, 8 };
            CollectionAssert.AreEquivalent(valoresFinales, resultado);
        }
    }
}
