const dotenv = require('dotenv').config();

module.exports = {
  NODE_ENV: process.env.NODE_ENV,
  HOST: process.env.HOST || '127.0.0.1',
  PORT: process.env.PORT || 3000,
  CONNECTION: process.env.CONNECTION
}