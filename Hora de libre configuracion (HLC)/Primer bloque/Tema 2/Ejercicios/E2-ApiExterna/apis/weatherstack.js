const axios = require('axios')

const params = {
    access_key: 'b2a4060249c7c6d03cea291b6dbc2f0b',
    query: ''
}

const show = (ciudad) => {
    console.log('funciona')
    params[query] = ciudad
    axios.get('http://api.weatherstack.com/current', {params})
      .then(response => {
        const apiResponse = response.data;
        console.log(`Current temperature in ${apiResponse.location.name} is ${apiResponse.current.temperature}℃`);
      }).catch(error => {
        console.log(error);
      });
}

module.exports = {
    show: show
}