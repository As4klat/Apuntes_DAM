<%@ Page Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Area.aspx.cs" Inherits="Ejercicio2_web_form.Area" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="row">
                    <div class="col">
                        <p>Triangulo</p>
                    </div>
                    <div class="col">
                        <div class="row mb-3">
                            <label for="baset" class="col-sm-2 col-form-label">Base:</label>
                            <div class="col-sm-10">
                                <asp:TextBox ID="baset" runat="server"></asp:TextBox>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="alturat" class="col-sm-2 col-form-label">Altura:</label>
                            <div class="col-sm-10">
                                <asp:TextBox ID="alturat" runat="server"></asp:TextBox>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <asp:Button CssClass="btn btn-outline-primary" ID="calcularTriangulo" runat="server" Text="Calcular" OnClick="calcularTriangulo_Click" />
                            <asp:Label ID="resultadot" runat="server" Text=""></asp:Label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="row">
                    <div class="col">
                        <p>Cuadrado</p>
                    </div>
                    <div class="col">
                        <div class="row mb-3">
                            <label for="ladoc" class="col-sm-2 col-form-label">Lado:</label>
                            <div class="col-sm-10">
                                <asp:TextBox ID="ladoc" runat="server"></asp:TextBox>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <asp:Button CssClass="btn btn-outline-primary" ID="calcularCuadrado" runat="server" Text="Calcular" OnClick="calcularCuadrado_Click" />
                            <asp:Label ID="resultadoc" runat="server" Text=""></asp:Label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
