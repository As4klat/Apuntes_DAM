<%@ Page Language="C#" AutoEventWireup="true" MasterPageFile="~/Site.Master" CodeBehind="Register.aspx.cs" Inherits="Prueba_final.Paginas.Sesion.Register" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <div id="template-bg-1">
        <div
            class="d-flex flex-column min-vh-100 justify-content-center align-items-center">
            
            <% if (_Error) { %>
            <div class="card p-4 text-light bg-dark mb-5">
                <div class="card-body w-100">
                    <asp:Label ID="ErrorLabel" CssClass="text-danger" runat="server" Text=""></asp:Label>
                </div>
            </div>
            <% } %>
            <div class="card p-4 text-light bg-dark mb-5">
                <div class="card-header">
                    <h3>Registrarse</h3>
                </div>
                <div class="card-body w-100">
                    <div class="input-group form-group mt-3">
                        <div class="col">
                            <div class="row">
                                <asp:TextBox ID="email" runat="server" CssClass="form-control" placeholder="Email"></asp:TextBox>
                            </div>
                            <div class="row">
                                <% if (!emailValidator.IsValid) { %>
                                <asp:RegularExpressionValidator CssClass="text-danger" ID="emailValidator" runat="server" ErrorMessage="El email es invalido" ControlToValidate="email" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*" />
                                <% } %>
                                <% if (!emailRequired.IsValid) { %>
                                <asp:RequiredFieldValidator CssClass="text-danger" ID="emailRequired" runat="server" ErrorMessage="Campo obligatorio" ControlToValidate="email" />
                                <% } %>
                            </div>
                        </div>
                    </div>

                    <div class="input-group form-group mt-3">
                        <div class="col">
                            <div class="row">
                                <asp:TextBox ID="password" runat="server" TextMode="Password" CssClass="form-control" placeholder="Contraseña"></asp:TextBox>
                            </div>
                            <div class="row">
                                <% if (!passwordRequerido.IsValid) { %>
                                <asp:RequiredFieldValidator CssClass="text-danger" ID="passwordRequerido" runat="server" ErrorMessage="Campo obligatorio" ControlToValidate="password" />
                                <% } %>
                            </div>
                        </div>
                    </div>
                    <div class="input-group form-group mt-3">
                        <div class="col">
                            <div class="row">
                                <asp:TextBox ID="confirmPassword" runat="server" TextMode="Password" CssClass="form-control" placeholder="Confirmar contraseña"></asp:TextBox>
                            </div>
                            <div class="row">
                                <% if (!confirmPasswordRequerido.IsValid) { %>
                                <asp:RequiredFieldValidator CssClass="text-danger" ID="confirmPasswordRequerido" runat="server" ErrorMessage="Campo obligatorio" ControlToValidate="confirmPassword" />
                                <% } %>
                                <% if (!comparePassword.IsValid) { %>
                                <asp:CompareValidator ID="comparePassword" CssClass="text-danger" runat="server" ErrorMessage="Las contraseñan deben ser iguales" ControlToValidate="password" ControlToCompare="confirmPassword" Type="String"></asp:CompareValidator>
                                <% } %>
                            </div>
                        </div>
                    </div>

                    <div class="form-group mt-3">
                        <asp:Button CssClass="btn bg-secondary float-end text-white w-100" ID="btnRegistro" runat="server" Text="Registrarse" OnClick="RegistrarUsuario" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
