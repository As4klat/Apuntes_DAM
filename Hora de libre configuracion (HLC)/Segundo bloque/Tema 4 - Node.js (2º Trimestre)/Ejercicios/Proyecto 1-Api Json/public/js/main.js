const apiForm = document.querySelector('#apiForm')
const entrada = document.querySelector('#apiInput')
const messageOne = document.querySelector('#message-1')
const messageTwo = document.querySelector('#message-2')

apiForm.addEventListener('submit', (e) => {
    e.preventDefault()

    const location = entrada.value

    messageOne.textContent = 'Loading...'
    messageTwo.textContent = ''

    fetch('http://localhost:3000/weatherstack?city=' + location).then((response) => {
        response.json().then((data) => {
            if (data.error) {
                messageOne.textContent = data.error
            } else {
                messageOne.textContent = data.temperatura
                console.log(data.temperatura)
            }
        })
    })
})