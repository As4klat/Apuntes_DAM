<%@ Page Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="calculadora.aspx.cs" Inherits="Actividad22.calculadora" %>


<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="row">
        <div class="col-6">
            <asp:TextBox ID="numero1" runat="server"></asp:TextBox>
            <asp:RegularExpressionValidator runat="server" ErrorMessage="Tienen que ser numeros" ControlToValidate="numero1" ValidationExpression="^\d+$"></asp:RegularExpressionValidator>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Campo obligatorio" ControlToValidate="numero1"></asp:RequiredFieldValidator>
        </div>
        <div class="col-6">
            <asp:TextBox ID="numero2" runat="server"></asp:TextBox>
            <asp:RegularExpressionValidator runat="server" ErrorMessage="Tienen que ser numeros" ControlToValidate="numero2" ValidationExpression="^\d+$"></asp:RegularExpressionValidator>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="Campo obligatorio" ControlToValidate="numero2"></asp:RequiredFieldValidator>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <asp:Label ID="resultado" runat="server" Text=""></asp:Label>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <asp:Button CssClass="btn btn-outline-primary" ID="sumar" runat="server" Text="Sumar" OnClick="Calcular_Suma" />
        </div>
        <div class="col-3">
            <asp:Button CssClass="btn btn-outline-secondary" ID="restar" runat="server" Text="Restar" OnClick="Calcular_Resta" />            
        </div>
        <div class="col-3">
            <asp:Button CssClass="btn btn-outline-success" ID="dividir" runat="server" Text="Dividir" OnClick="Calcular_Division" />
        </div>
        <div class="col-3">
            <asp:Button CssClass="btn btn-outline-dark" ID="multiplicar" runat="server" Text="Multiplicar" OnClick="Calcular_Multiplicacion" />
        </div>
    </div>

</asp:Content>
