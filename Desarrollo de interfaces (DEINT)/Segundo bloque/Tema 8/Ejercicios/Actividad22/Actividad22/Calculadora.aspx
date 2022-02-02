<%@ Page Title="Calculadora" Language="vb" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Calculadora.aspx.vb" Inherits="Actividad22.Calculadora" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container">
        <div class="row mt-5">
            <div class="col-8">
                <div class="row">
                    <div class="col">
                        <input id="num1" type="text" class="form-control" placeholder="Numero 1" aria-label="Numero 1">
                    </div>
                    <div class="col">
                        <select id="operador" class="form-select">
                            <option selected>+</option>
                            <option>-</option>
                            <option>/</option>
                            <option>x</option>
                        </select>
                    </div>
                    <div class="col">
                        <input id="num2" type="text" class="form-control" placeholder="Numero 2" aria-label="Numero 2">
                    </div>
                </div>
                <div class="row mt-1">
                    <div class="col-10">
                        <button type="button" class="btn btn-outline-primary">Calcular</button>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="d-flex align-items-center">
                    <p id="sol">Solucion: </p>
                </div>
            </div>
        </div>
    </div>
    
</asp:Content>
