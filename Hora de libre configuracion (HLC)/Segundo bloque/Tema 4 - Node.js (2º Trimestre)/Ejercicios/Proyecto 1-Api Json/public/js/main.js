const apiForm = document.querySelector('#apiForm')
const entrada = document.querySelector('#apiInput')
const loading = document.querySelector('#load')

apiForm.addEventListener('submit', (e) => {
    e.preventDefault()

    const location = entrada.value
    loading.innerHTML = `
    <div class="spinner-border" role="status">
        <span class="visually-hidden">Loading...</span>
    </div>
    `

    fetch('http://localhost:3000/weatherstack?city=' + location).then((response) => {
        response.json().then((data) => {
            var html=""
            if (data.error) {
                html = `
                <div id="card" class="card">
                    <img src="/img/no-result.png" class="card-img-top" alt="no-result">
                    <div class="card-body">
                        <h5 class="card-title">${data.error}</h5>
                    </div>     
                </div>
                `
            } else {
                html = `
                <div id="card" class="card">
                    <img src="${data.urlIcon}" class="card-img-top" alt="clima">
                    <div class="card-img-overlay">
                        <p class="card-text">Temperatura: ${data.temperatura} ºC</p>
                        <p class="card-text">Humedad: ${data.humedad}%</p>
                    </div>
                    <div class="card-body text-center">
                        <h5 class="card-title">${location}</h5>
                        <p class="card-text">${data.descripcionTiempo}</p>
                        <p class="card-text text-end">${data.tiempoObservacion}</p>
                    </div>
                </div>`
            }
            loading.innerHTML = html
        })
    })
})