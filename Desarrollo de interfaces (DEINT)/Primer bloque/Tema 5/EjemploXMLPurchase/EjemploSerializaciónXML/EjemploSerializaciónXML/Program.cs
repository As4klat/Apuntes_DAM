using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Serialization;
using System.IO;

namespace EjemploSerializaciónXML
{
       
            // El XmlRootAttribute permite establecer un nombre alternativo 
            // (PurchaseOrder) para el elemento XML y su namespace. 
            //Por defecto, el XmlSerializer usa el nombre de la clase. El atributo
            //también permite establecer el namespace XML para el elemento. 
            // Por último establece la propiedad IsNullable, la cual especifica
            //si el xsi:null atributo aparece si la instacia de la clase se establece
            //como una referencia nula
        [XmlRootAttribute("PurchaseOrder", Namespace = "www.dam.es",IsNullable = false)]
        public class PurchaseOrder
        {
            public Address ShipTo;
            public string OrderDate;
            //El XMLArrayAttribute cambia el nombre de XML element
            //de OrderedItems a Items
            [XmlArrayAttribute("Items")]
            public OrderedItem[] OrderedItems;
            public decimal SubTotal;
            public decimal ShipCost;
            public decimal TotalCost;
        }

        public class Address
        {
        //El XmlAttribute indica al XmlSerializer como serializar el campo Name
        //como un XML atributo en lugar de un XML element (que sería el comportamiento por
        //defecto)
            [XmlAttribute]
            public string Name;
            public string Line1;
            //Estableciendo la propiedad IsNullable a false indicamos al XmlSerializer
            //que el atributo XML no aparecerá si el campo City se establece como nulo
           [XmlElementAttribute(IsNullable = false)]
            public string City;
            public string State;
            public string Zip;
        }

        public class OrderedItem
        {
            public string ItemName;
            public string Description;
            public decimal UnitPrice;
            public int Quantity;
            public decimal LineTotal;
            //Calculate es un método que calcula el precio por item y almacena el valor
            //en el campo
            public void Calculate()
            {
                LineTotal = UnitPrice * Quantity;
            }
        }

        public class Test
        {
            public static void Main()
            {
                // Lee y escribe órdenes de compra
                Test t = new Test();
                t.CreatePO("po.xml");
                t.ReadPO("po.xml");
                Console.ReadKey();
            }

            private void CreatePO(string filename)
            {
                //Crea una instancia de XmlSerializer 
                //especificamos el tipo de objeto a serializar
                XmlSerializer serializer =
                new XmlSerializer(typeof(PurchaseOrder));
                TextWriter writer = new StreamWriter(filename);
                PurchaseOrder po = new PurchaseOrder();
                //Crea una dirección de pago
                Address billAddress = new Address();
                billAddress.Name = "Teresa Atkinson";
                billAddress.Line1 = "1 Main St.";
                billAddress.City = "AnyTown";
                billAddress.State = "WA";
                billAddress.Zip = "00000";
                //Establece ShipTo and BillTo a la misma dirección
                po.ShipTo = billAddress;
                po.OrderDate = System.DateTime.Now.ToLongDateString();

                // Crea un OrderedItem.
                OrderedItem i1 = new OrderedItem();
                i1.ItemName = "Widget S";
                i1.Description = "Small widget";
                i1.UnitPrice = (decimal)5.23;
                i1.Quantity = 3;
                i1.Calculate();

                // Lo inserta en el array
                OrderedItem[] items = { i1 };
                po.OrderedItems = items;
                // Calculate the total cost.
                decimal subTotal = new decimal();
                foreach (OrderedItem oi in items)
                {
                    subTotal += oi.LineTotal;
                }
                po.SubTotal = subTotal;
                po.ShipCost = (decimal)12.51;
                po.TotalCost = po.SubTotal + po.ShipCost;
                // Serializamos la orden de compra y cerramos el TextWriter
                serializer.Serialize(writer, po);
                writer.Close();
            }

            protected void ReadPO(string filename)
            {
            //Crea una instancia de XmlSerializer 
            //especificamos el tipo de objeto a serializar
            XmlSerializer serializer = new XmlSerializer(typeof(PurchaseOrder));
            //Si el documento XML ha sido alterado con nodos o atributos desconocidos
            //los maneja con los eventos UnknownNode y UnknownAttribute
                serializer.UnknownNode += new XmlNodeEventHandler(serializer_UnknownNode);
                serializer.UnknownAttribute += new XmlAttributeEventHandler(serializer_UnknownAttribute);

                
                FileStream fs = new FileStream(filename, FileMode.Open);
                // Declaramos una variable del objeto a deserializar
                PurchaseOrder po;
                //Usamos el método Deserialize para restablecer el estado del objeto con 
                //los datos del documento XML
                po = (PurchaseOrder)serializer.Deserialize(fs);
                // Leemos la fecha
                Console.WriteLine("OrderDate: " + po.OrderDate);

                // Leemos la dirección de envio
                Address shipTo = po.ShipTo;
                ReadAddress(shipTo, "Ship To:");
                // Leemos la lista de items
                OrderedItem[] items = po.OrderedItems;
                Console.WriteLine("Items to be shipped:");
                foreach (OrderedItem oi in items)
                {
                    Console.WriteLine("\t" +
                    oi.ItemName + "\t" +
                    oi.Description + "\t" +
                    oi.UnitPrice + "\t" +
                    oi.Quantity + "\t" +
                    oi.LineTotal);
                }
                // Leemos el subtotal, gastos de envío y gastos totales
                Console.WriteLine(
                "\n\t\t\t\t\t Subtotal\t" + po.SubTotal +
                "\n\t\t\t\t\t Shipping\t" + po.ShipCost +
                "\n\t\t\t\t\t Total\t\t" + po.TotalCost
                );
            }

            protected void ReadAddress(Address a, string label)
            {
                // Método para leer los campos de la dirección
                Console.WriteLine(label);
                Console.Write("\t" +
                a.Name + "\n\t" +
                a.Line1 + "\n\t" +
                a.City + "\t" +
                a.State + "\n\t" +
                a.Zip + "\n");
            }

            protected void serializer_UnknownNode
            (object sender, XmlNodeEventArgs e)
            {
                Console.WriteLine("Unknown Node:" + e.Name + "\t" + e.Text);
            }

            protected void serializer_UnknownAttribute
            (object sender, XmlAttributeEventArgs e)
            {
                System.Xml.XmlAttribute attr = e.Attr;
                Console.WriteLine("Unknown attribute " + attr.Name + "='" + attr.Value + "'");
            }
        }
    }

