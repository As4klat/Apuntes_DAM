<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Site.Master" CodeBehind="Login.aspx.cs" Inherits="Prueba_final.Paginas.Login" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <div id="template-bg-1">
        <div
            class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
            <div class="card p-4 text-light bg-dark mb-5">
                <div class="card-header">
                    <h3>Iniciar sesión </h3>
                </div>
                <div class="card-body w-100">
                    <div class="input-group form-group mt-3">
                            <asp:TextBox ID="email" runat="server" CssClass="form-control" placeholder="Email"></asp:TextBox>

                            <% if (!emailValidator.IsValid)
                                { %>
                            <asp:RegularExpressionValidator CssClass="text-danger" ID="emailValidator" runat="server" ErrorMessage="El email es invalido" ControlToValidate="email" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" />
                            <% } %>
                            <% if (!emailRequerido.IsValid)
                                { %>
                            <asp:RequiredFieldValidator CssClass="text-danger" ID="emailRequerido" runat="server" ErrorMessage="Campo obligatorio" ControlToValidate="email" />
                            <% } %>
                        </div>
                        <div class="input-group form-group mt-3">
                            <asp:TextBox ID="password" runat="server" TextMode="Password" CssClass="form-control" placeholder="Contraseña"></asp:TextBox>
                            <% if (!passwordRequerido.IsValid)
                                { %>
                            <asp:RequiredFieldValidator CssClass="text-danger" ID="passwordRequerido" runat="server" ErrorMessage="Campo obligatorio" ControlToValidate="password" />
                            <% } %>
                        </div>
                        <div class="form-group mt-3">
                            
                            <asp:Button CssClass="btn bg-secondary float-end text-white w-100" ID="btnInicioSesion" runat="server" Text="Iniciar sesión" OnClick="Iniciar_sesion" />
                        </div>
                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-center">
                        <p>Si no tienes cuenta pincha <a class="text-primary" href="Register.aspx">aqui.</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
