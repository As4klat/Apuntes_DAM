const path = require('path')
const express = require('express')
const hbs = require('hbs')
const postman = require('postman-request')
const weatherstack = require('../src/utils/weatherstack')

const app = express()

const publicDirectoryPath = path.join(__dirname, '../public')
const viewsPath = path.join(__dirname, '../templates/views')
const partialsPath = path.join(__dirname, '../templates/partials')

const apikey = "6d0bfe59aaed78ad2a74efb1e3abe886"

app.set('view engine', 'hbs')
app.set('views', viewsPath)
hbs.registerPartials(partialsPath)

app.use(express.static(publicDirectoryPath))

app.get('', (req, res) => {
    res.render('index', {
        title: 'Aplicación api',
        name: 'Alejandro Gamaza Martínez'
    })
})

app.get('/about', (req, res) => {
    res.render('about', {
        title: 'Sobre la api',
        name: 'Alejandro Gamaza Martínez'
    })
})

app.get('/help', (req, res) => {
    res.render('help', {
        title: 'Ayuda',
        name: 'Alejandro Gamaza Martínez'
    })
})

app.get('/weatherstack', (req, res) => {
    //http://api.weatherstack.com/current?access_key=&query = New York
    var ciudad = req.query.city
    postman('http://api.weatherstack.com/current?access_key='+ apikey +'&query='+ciudad, (respuesta, body) => {
        if(respuesta.statusCode==200){
            var jsonRespuesta = JSON.parse(body)
            res.send({
                temperatura: jsonRespuesta.current.temperature
            })
        }
    })
})

app.listen(3000, () => {
    console.log('Server is up on port 3000.')
})