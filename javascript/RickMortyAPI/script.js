const URL = "https://rickandmortyapi.com/api/"
const episodesHTML = document.getElementById("episodes")
const episodeHTML = document.getElementById("episode")
const charactersHTML = document.getElementById("characters")
let list = []

async function getEpisodes() {
    const reponse = await fetch(URL+"episode")
    const json = await reponse.json()
    const pages = await json.info.pages
    for(i=1;i<=pages;i++) {
        const episodes = await fetch(URL+`episode?page=${i}`)
        .then(response => response.json())
        .then(data => data.results)
        .then(data => {
            data.forEach(element => {
                list.push(element)      
            });
        })
    }
    createOptions(list)
    let episode = list[0];
    updateEpisode(episode)
    getCharacters(episode.characters)
    console.log(episode)
}

async function getCharacter(url) {
    const reponse = await fetch(url)
    const json = await reponse.json()
    return json
}

async function getCharacters(characters) {
    const oldCharacters = document.getElementsByClassName("character")
    for (const element of oldCharacters) {
        charactersHTML.removeChild(element)
    }
    createCharacters(characters)
}

async function createCharacters(characters) {
    for (const element of characters) {
        const character = await getCharacter(element)
        const newCharacterHTML = document.createElement("div")
        newCharacterHTML.classList.add("character")
        newCharacterHTML.innerHTML = `<img src="${character.image}"/><p><strong>Name:</strong> ${character.name}</p><p><strong>Gender:</strong> ${character.gender}</p><p><strong>Species:</strong> ${character.species}</p><p><strong>Location:</strong> ${character.location.name}</p><p><strong>Status:</strong> ${character.status}</p>`
        charactersHTML.appendChild(newCharacterHTML)
        console.log(character)
    }
}

function createOptions(list) {
    list.forEach(element => {
        const newOptionHTML = document.createElement("option")
        newOptionHTML.value = element.id
        newOptionHTML.innerHTML = `${element.episode}: ${element.name}`
        episodesHTML.appendChild(newOptionHTML)
    })
}

function updateEpisode(episode) {
    const url_name = episode.name.replace(" ", "_").replace("#", "No._")
    episodeHTML.innerHTML = `<h3>Episode ${episode.episode}: "${episode.name}"</h3><p>(Air date: ${episode.air_date})</p><a href="${episode.url}" target="_blank">API Episode link</a><a href="https://rickandmorty.fandom.com/wiki/${url_name}" target="_blank">Fandom wiki page</a>`
}

episodesHTML.addEventListener("change", (e) => {
    episode = list[e.target.value-1];
    updateEpisode(episode)
    getCharacters(episode.characters)
})

getEpisodes()