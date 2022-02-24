<%@ Page Title="Inicio" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Prueba_final._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <div class="container-md">
        <%  if (dataUser == null)
            {%>
        <p>Por favor compruebe su clave Api que tenga los permisos necesarios</p>
        <%}
            else
            {%>
        <div class="my-4 mx-5">
            <div class="row mt-2">
                <asp:Label CssClass="display-3" ID="nombreJugador" runat="server" Text=""></asp:Label>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <asp:Label ID="tiempoJuego" runat="server" Text="Tiempo de juego: "></asp:Label>
                    
                </div>
                <div class="col">
                    <asp:Label ID="servidorOrigen" runat="server" Text="Servidor de origen: "></asp:Label>
                    
                </div>
            </div>
            <div class="row mt-2">
                <div class="col">
                    <asp:Label ID="nivelFractales" runat="server" Text="Nivel de fractales: "></asp:Label>                    
                </div>
                <div class="col">
                    <asp:Label ID="nivelMcM" runat="server" Text="Nivel de Mundo contra mundo: "></asp:Label>
                </div>
            </div>
        </div>
        <%} %>
    </div>


</asp:Content>
