<%@ Page Title="Sobre la api" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="About.aspx.cs" Inherits="Prueba_final.About" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="container-md mt-5">
        <div class="row justify-content-md-left">
            <div class="col col-lg-8">
                <h2 class="h2"><%: Title %>.</h2>
                <p class="text-left">
                    Es una interfaz que permite a las aplicaciones de terceros acceder a los datos directamente desde los servidores de Guild Wars 2.
                    La versión actual de la API es la versión 2.
                </p>
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-10">
                <div class="container">
                    <h3 class="h3">Modo de empleo
                    <small class="text-muted">v1 | v2</small>
                    </h3>
                    <h4 class="h4">Autenticación</h4>
                    <p class="text-left">
                        La mayoría de las rutas finales devuelven resultados generales sobre los datos del juego y, por tanto, no requieren autenticación.
                    Las rutas finales que pueden utilizarse para devolver datos específicos de usuarios o gremios requieren autenticación mediante una clave de API de una de las dos maneras.
                    </p>
                    <p class="text-left">
                        <em>Para más información pinche <a href="https://help.guildwars2.com/hc/es/articles/230899908-Gestionar-tu-cuenta-de-ArenaNet">aquí</a></em>
                    </p>
                    <ul>
                        <li>Cabecera de solicitud de autorización: <code>Authorization: Bearer [api key]</code></li>
                        <li>Parámetro de consulta access_token: <code>?access_token=[api key]</code></li>
                    </ul>
                </div>
                <div class="container-md">
                    <h3 class="h3">Rutas de api
                    <small class="text-muted">v2</small>
                    </h3>
                    <h4 class="h4">Logros</h4>
                    <p class="text-left">
                        <ul>
                            <li><code>achievements:</code> Devuelve información sobre los logros.</li>
                            <li><code>achievements/daily:</code> Devuelve información sobre los logros diarios.</li>
                            <li><code>achievements/daily/tomorrow:</code> Devuelve información sobre los próximos logros diarios.</li>
                            <li><code>achievements/groups:</code> Devuelve información sobre los grupos de logros.</li>
                            <li><code>achievements/categories:</code> Devuelve información sobre las categorías de logros.</li>
                        </ul>
                    </p>

                    <h4 class="h4">Logros</h4>
                    <p class="text-left">
                        Esta sección necesita usar la clave api.
                        <ul>
                            <li><code>account:</code> Devuelve información sobre una cuenta asociada a una clave API.</li>
                            <li><code>account/achievements:</code> Devuelve información sobre un banco asociado a una clave API.</li>
                            <li><code>account/bank:</code> Devuelve información sobre un banco asociado a una clave API.</li>
                            <li><code>account/dailycrafting:</code> Devuelve información sobre los materiales crafteados (diariamente) (desde el último reinicio) asociados a una clave API.</li>
                            <li><code>account/dungeons:</code>Devuelve información sobre las mazmorras despejadas diariamente asociadas a una clave API.</li>
                            <li><code>account/dyes:</code>Devuelve información sobre los tintes desbloqueados asociados a una clave de API.</li>
                            <li><code>account/finishers:</code>Devuelve información sobre los remates desbloqueados asociados a una clave de API.</li>
                            <li><code>account/gliders:</code>Devuelve información sobre los planeadores desbloqueados asociados a una clave de API.</li>
                            <li><code>account/home/cats:</code>Devuelve información sobre los gatos desbloqueados en la instancia de casa asociada a una clave de API.</li>
                            <li><code>account/home/nodes:</code>Devuelve información sobre los nodos desbloqueados en la instancia de casa asociada a una clave de API.</li>
                            <li><code>account/inventory:</code>Devuelve información sobre las ranuras de inventario compartidas asociadas a una clave de API.</li>
                            <li><code>account/luck:</code>Devuelve información sobre la suerte adquirida asociada a una clave API</li>
                            <li><code>account/legendaryarmory:</code>Devuelve información sobre la Armería Legendaria asociada a una clave API.</li>
                            <li><code>account/mailcarriers:</code>Devuelve información sobre los portadores de correo asociados a una clave de API.</li>
                            <li><code>account/mapchests:</code>Devuelve información sobre las recompensas (diarias) de cofres de mapa recibidas (desde el último reinicio) asociadas a una clave de API.</li>
                            <li><code>account/masteries:</code>Devuelve información sobre las maestrías desbloqueadas asociadas a una clave API.</li>
                            <li><code>account/mastery/points:</code>Devuelve información sobre la cantidad total de puntos de maestría asociados a una clave API.</li>
                            <li><code>account/materials:</code>Devuelve información sobre el almacenamiento de materiales asociado a una clave de API.</li>
                            <li><code>account/minis:</code>Devuelve información sobre las miniaturas desbloqueadas asociadas a una clave API.</li>
                            <li><code>account/mounts/skins:</code>Devuelve información sobre las apariencias de montura desbloqueadas asociadas a una clave de API.</li>
                            <li><code>account/mounts/types:</code>Devuelve información sobre las monturas desbloqueadas asociadas a una clave de API.</li>
                            <li><code>account/novelties:</code>Devuelve información sobre las novedades desbloqueadas asociadas a una clave de API.</li>
                            <li><code>account/outfits:</code>Devuelve información sobre los atuendos desbloqueados asociados a una clave de API.</li>
                            <li><code>account/pvp/heroes:</code>Devuelve información sobre los héroes PvP desbloqueados asociados a una clave API.</li>
                            <li><code>account/raids:</code>Devuelve información sobre los eventos de incursión completados entre los reinicios semanales asociados a una clave de API.</li>
                            <li><code>account/recipes:</code>Devuelve información sobre las recetas de artesanía desbloqueadas asociadas a una clave API.</li>
                            <li><code>account/skins:</code>Devuelve información sobre los aspectos desbloqueados asociados a una clave de API.</li>
                            <li><code>account/titles:</code>Devuelve información sobre los títulos desbloqueados asociados a una clave de API.</li>
                            <li><code>account/wallet:</code>Devuelve información sobre la riqueza asociada a una clave de API.</li>
                            <li><code>account/worldbosses:</code>Devuelve información sobre los jefes de mundo (diarios) de Core Tyria (desde el último reinicio) asociados a una clave de API.</li>
                        </ul>
                    </p>
                </div>
            </div>
        </div>

    </div>
</asp:Content>
