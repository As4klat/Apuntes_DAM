const yargs = require('yargs')
const weatherstack = require('./apis/weatherstack.js')

yargs.command({
    command: 'mostrarClima',
    describe: 'Muestra el clima de la ciudad que le pasemos.',
    builder: {
        ciudad: {
            describe: 'Nombre de la ciudad a mostrar.',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv) {
        weatherstack.show(argv.ciudad)
    }
})

yargs.parse()