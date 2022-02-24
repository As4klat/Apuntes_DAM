<%@ Page Title="Cuenta" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Cuenta.aspx.cs" Inherits="Prueba_final.Contact" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container-md mt-5">
        <div class="row justify-content-md-left">
            <div class="col col-lg-6">
                <h2 class="h2"><%: Title %>.</h2>
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-8">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="cuenta-tab" data-bs-toggle="tab" data-bs-target="#cuenta" type="button" role="tab" aria-controls="cuenta" aria-selected="true">Perfil</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="claveApi-tab" data-bs-toggle="tab" data-bs-target="#claveApi" type="button" role="tab" aria-controls="claveApi" aria-selected="false">Clave API</button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="cuenta" role="tabpanel" aria-labelledby="cuenta-tab">
                        <div class="m-4">
                            <h4 class="display-4 text-center">Administración de cuenta</h4>
                            <div class="container">
                                <% if (_Error)
                                    { %>
                                <div class="card p-4 text-light bg-dark mb-5">
                                    <div class="card-body w-100">
                                        <asp:Label ID="ErrorLabel" CssClass="text-danger" runat="server" Text=""></asp:Label>
                                    </div>
                                </div>
                                <% } %>
                                <div class="row">
                                    <div class="col border py-3">
                                        <h4 class="h4 my-2">Cambiar email</h4>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text" id="basic-addon1">@</span>
                                            </div>
                                            <asp:TextBox ID="email" runat="server" CssClass="input-control bg-light shadow-sm border-0" placeholder="Email" aria-describedby="basic-addon1"></asp:TextBox>
                                            <% if (_emailValidator)
                                                { %>
                                            <asp:Label ID="emailValidar" CssClass="text-danger" runat="server" Text="El email es invalido"></asp:Label>
                                            <% } %>
                                            <% if (_emailRequired)
                                                { %>
                                            <asp:Label ID="emailRequerido" CssClass="text-danger" runat="server" Text="Campo obligatorio"></asp:Label>
                                            <% } %>
                                        </div>
                                        <div class="row-2">
                                            <asp:Button CssClass="btn bg-secondary m-2 bt-md text-white" ID="btnActualizarEmail" runat="server" Text="Enviar" OnClick="btnActualizarEmail_Click" />
                                        </div>
                                        <div class="row">
                                            <small>Nos compremetemos a que nunca, nunca, le enviaremos correo que no desee o le daremos su correo electrónico a extraños.</small>
                                        </div>
                                    </div>
                                    <div class="col border">
                                        <div class="m-3">
                                            <h4 class="h4 my-2">Actualizar contraseña</h4>
                                            <div class="form-group">
                                                <asp:TextBox ID="actualPassword" runat="server" TextMode="Password" CssClass="form-control bg-light shadow-sm border-0" placeholder="Contraseña actual"></asp:TextBox>
                                            </div>
                                            <div class="form-group mt-3">
                                                <asp:TextBox ID="password" runat="server" TextMode="Password" CssClass="form-control bg-light shadow-sm border-0" placeholder="Contraseña"></asp:TextBox>
                                                <% if (_contraseñaRequerida)
                                                    { %>
                                                <asp:Label ID="contraseñaRequerida" CssClass="text-danger" runat="server" Text="Campo obligatorio"></asp:Label>
                                                <% } %>
                                            </div>
                                            <div class="form-group my-1">
                                                <asp:TextBox ID="confirmPassword" runat="server" TextMode="Password" CssClass="form-control bg-light shadow-sm border-0" placeholder="Confirmar contraseña"></asp:TextBox>
                                                <% if (_contraseñaCompareRequerida)
                                                    { %>
                                                <asp:Label ID="contraseñaCompareRequerida" CssClass="text-danger" runat="server" Text="Campo obligatorio"></asp:Label>
                                                <% } %>
                                                <% if (_contraseñasIguales)
                                                    { %>
                                                <asp:Label ID="contraseñasIguales" CssClass="text-danger" runat="server" Text="Las contraseñan deben ser iguales"></asp:Label>
                                                <% } %>
                                            </div>
                                            <asp:Button CssClass="btn bg-secondary m-2 bt-md float-start text-white" ID="btnActualizarContraseña" runat="server" Text="Enviar" OnClick="btnActualizarContraseña_Click" />
                                        </div>
                                    </div>
                                    <div class="w-100"></div>
                                    <div class="col border">
                                        <div>
                                            <div class="m-3">
                                                <h2><strong>Aviso legal</strong></h2>
                                                <h3 class="mt-4">Aviso legal y términos de uso</h3>
                                                En este espacio, el USUARIO, podrá encontrar toda la información relativa a los términos y condiciones legales que definen las relaciones entre los usuarios y 
                        nosotros como responsables de esta web. Como usuario, es importante que conozcas estos términos antes de continuar tu navegación. Gw2gg.Como responsable de esta web,
                        asume el compromiso de procesar la información de nuestros usuarios y clientes con plenas garantías y cumplir con los requisitos nacionales y europeos que regulan la recopilación y uso de los datos personales de nuestros usuarios. 
                        Esta web, por tanto, cumple rigurosamente con el RGPD (REGLAMENTO (UE) 2016/679 de protección de datos) y la LSSI-CE la Ley 34/2002, de 11 de julio, de servicios de la sociedad de la información y de comercio electrónico.
                        
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="claveApi" role="tabpanel" aria-labelledby="claveApi-tab">

                        <div class="container">
                            <h4 class="h4 my-2">Tu api key aqui</h4>
                            <% if (_ErrorApi)
                                { %>
                            <p>Error al introducir la api key. Comprueba que:</p>
                            <ul>
                                <li>La clave tiene el formato correcto.</li>
                                <li>La has copiado desde tu cuenta de arenanet.</li>
                                <li>Ya existe una igual.</li>
                            </ul>
                            <% } %>

                            <asp:TextBox ID="userapikey" runat="server" TextMode="SingleLine" CssClass="form-control" placeholder="xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxxxxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx"></asp:TextBox>
                            <asp:Button CssClass="btn bg-secondary m-2 bt-md text-white" ID="btnGuardarApi" runat="server" Text="Guardar" OnClick="btnGuardarApi_Click" />
                            <h2 class="h2 my-2">Tu clave</h2>
                            <asp:Label ID="claveApiNueva" runat="server" Text=""></asp:Label>
                            <h3>Instrucciones</h3>
                            <ol>
                                <li>Abre el panel de gestión de <a href="https://account.arena.net">claves de API de Guild Wars 2</a>.</li>
                                <li>Haz clic en el botón de "nueva clave".</li>
                                <li>Introduce un nombre y marca todas las casillas de permisos.</li>
                                <li>Copia tu nueva clave de API. CTRL + C</li>
                                <li>Pégalo en la caja de arriba. CTRL + V</li>
                                <li>Haz clic en el botón de "Guardar".</li>
                                <li>¡Diviertete!</li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
