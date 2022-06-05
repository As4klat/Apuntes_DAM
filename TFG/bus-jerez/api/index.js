const config = require('./global')
const express = require('express')
require('./db/mongoose')
const userRouter = require('./routers/user')
const cursoRouter = require('./routers/curso')
const pruebasRouter = require('./routers/pruebas')

const app = express()
const port = config.PORT || 3000

app.use(express.json())
app.use(userRouter)
app.use(cursoRouter)
app.use(pruebasRouter)

app.listen(port, () => {
    console.log('Server is up on port ' + port)
})