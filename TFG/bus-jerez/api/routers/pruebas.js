const express = require('express')
const router = new express.Router()

router.get('/pruebas', async (req, res) => {
    curso = {
        "curso":"asdasdasda",
        "grado":"2"
    }
    res.send(curso)
})

module.exports = router