<%@ Page Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Cadenas.aspx.cs" Inherits="Actividad22.Cadenas" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <asp:TextBox ID="tb1" runat="server"></asp:TextBox>
    <asp:RequiredFieldValidator ControlToValidate="tb1" ID="RequiredFieldValidator1" runat="server" ErrorMessage="RequiredFieldValidator"></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ControlToValidate="tb1" ID="RegularExpressionValidator1" runat="server" ValidationExpression="^\w+$" ErrorMessage="RegularExpressionValidator"></asp:RegularExpressionValidator>
    <asp:TextBox ID="tb2" runat="server"></asp:TextBox> 
    <asp:RequiredFieldValidator ControlToValidate="tb2" ID="RequiredFieldValidator2" runat="server" ErrorMessage="RequiredFieldValidator"></asp:RequiredFieldValidator>
    <asp:RegularExpressionValidator ControlToValidate="tb2" ID="RegularExpressionValidator2" runat="server" ValidationExpression="^\w+$" ErrorMessage="RegularExpressionValidator"></asp:RegularExpressionValidator>
    <asp:Label ID="lbResultado" runat="server" Text="Label"></asp:Label>

    <asp:Button ID="btnVeces" runat="server" Text="Nº de Veces" OnClick="contarVeces" />
    <asp:Button ID="btnEliminar" runat="server" Text="Eliminar" OnClick="eliminar" />

</asp:Content>
