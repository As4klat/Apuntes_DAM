<%@ Page Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Volumen.aspx.cs" Inherits="Ejercicio2_web_form.Volumen" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="row">
                    <div class="col">
                        <p>Cubo</p>
                    </div>
                    <div class="col">
                        <div class="row mb-3">
                            <label for="aristac" class="col-sm-2 col-form-label">Arista:</label>
                            <div class="col-sm-10">
                                <asp:TextBox ID="aristac" runat="server"></asp:TextBox>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <asp:Button CssClass="btn btn-outline-primary" ID="calcularCubo" runat="server" Text="Calcular" OnClick="calcularCubo_Click" />
                            <asp:Label ID="resultadocubo" runat="server" Text=""></asp:Label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="row">
                    <div class="col">
                        <p>Cono</p>
                    </div>
                    <div class="col">
                        <div class="row mb-3">
                            <label for="radioc" class="col-sm-2 col-form-label">Radio:</label>
                            <div class="col-sm-10">
                                <asp:TextBox ID="radioc" runat="server"></asp:TextBox>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <label for="alturac" class="col-sm-2 col-form-label">Altura:</label>
                            <div class="col-sm-10">
                                <asp:TextBox ID="alturac" runat="server"></asp:TextBox>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <asp:Button CssClass="btn btn-outline-primary" ID="calcularCono" runat="server" Text="Calcular" OnClick="calcularCono_Click" />
                            <asp:Label ID="resultadocono" runat="server" Text=""></asp:Label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
