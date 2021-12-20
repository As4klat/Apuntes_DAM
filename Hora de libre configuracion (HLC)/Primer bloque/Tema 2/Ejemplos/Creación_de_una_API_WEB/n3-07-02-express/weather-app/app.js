const geocode = require('./utils/geocode')
const forecast = require('./utils/forecast')
const yargs = require('yargs')
//const address = process.argv[2]
geo = (address) => {
    if (!address) {
        console.log('Please provide an address')
    } else {
        geocode(address, (error, { latitude, longitude, location }) => {
            if (error) {
                return console.log(error)
            }
    
            forecast(latitude, longitude, (error, forecastData) => {
                if (error) {
                    return console.log(error)
                }
                console.log(location)
                console.log(forecastData)
            })
        })
    }
}

yargs.command({
    command: 'geocode',
    describe: 
    'aaaaaaaaaa',
    builder: {
        ip: {
            describe: 'Note title',
            demandOption: true,
            type: 'string'
        }
    },
    handler(argv){
        geo(argv.ip)
    }
})

yargs.parse()
