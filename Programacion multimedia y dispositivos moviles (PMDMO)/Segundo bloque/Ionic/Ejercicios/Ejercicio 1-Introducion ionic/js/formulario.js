let length = 0;
const list = document.getElementById('listaCursos');
const infiniteScroll = document.getElementById('infinite-scroll');

infiniteScroll.addEventListener('ionInfinite', async function () {
    if (length < users.length) {
        console.log('Cargando...');
        await wait(500);
        infiniteScroll.complete();
        appendItems(10);
        console.log('Done');
    } else {
        console.log('No hay cursos');
        infiniteScroll.disabled = true;
    }
});

function appendItems(number) {
    console.log('Número de cursos: ', length);
    const originalLength = length;
    for (var i = 0; i < number; i++) {
        const el = document.createElement('ion-item');
        el.innerHTML = `
          <ion-label>
            <h2>Curso ${}</h2>
            <p></p>
          </ion-label>
        `;
        list.appendChild(el);
        length++;
    }
}

function wait(time) {
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve();
        }, time);
    });
}

appendItems(20);