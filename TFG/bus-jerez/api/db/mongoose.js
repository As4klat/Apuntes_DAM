const config = require('../global')
const mongoose = require('mongoose')

mongoose.connect(config.CONNECTION)
