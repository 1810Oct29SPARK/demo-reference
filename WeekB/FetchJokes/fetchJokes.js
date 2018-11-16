let state = {
    joke: ''
};

const apiUrl = 'https://icanhazdadjoke.cm/';

//long form of
//function getJokeWithFetch(){...}

//using promises
let getJokeWithFetch = function() {
    fetch(apiUrl, {method: "GET", headers:{"Accept":"application/json"}})
    //define behavior for when the response returns
    .then((response) => {
        //return unwrapped promise object for the next chaining operation
        return response.json();
    })
        //utilize unwrapped promise a javascript object
    .then((data) => {
        console.log(data);
        state.joke = data.joke;
        updateContent();
    })
        //what if there's a problem?
    .catch( (error) => {
        alert('oh no :(');
        console.log(error);
    });
}

let updateContent = function() {
    console.log(state);
    //select joke 
    const jokeElement = document.getElementById('joke-field');
    jokeElement.innerText = state.joke;
}

document.getElementById('new-joke-button').addEventListener('click',getJokeWithFetch);

/*
what if we want to request info from another API? 
*/

//Weather API

let tampaWeather = {};

//send a GET request to this endpoint to get Tampa weather
let weatherApiUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Tampa,us&units=imperial&APPID=859d47520ac736ebe8bbce1fef74269c';
function getTampaWeather() {
    fetch(weatherApiUrl).then((response) => {return response.json();
    }).then((data) => {
        tampaWeather = data;
        console.log(data);
        console.log('the temperature is: '+tampaWeather.main.temp+' degrees');
        updateWeather();
    });
}

function updateWeather() {
    let newPara = document.createElement('p')
    newPara.innerText = 'the temperature is: '+tampaWeather.main.temp+' degrees';
    //add new p element as a child of weatherDiv
    document.getElementById('weatherDiv').appendChild(newPara);
}

/*
    What's going on under the hood ^^
*/
function sendAjaxGet(url, func) {
    //first: obtain xhr
    var xhr = new XMLHttpRequest();
    //second: define onreadystatechange
    xhr.onreadystatechange = function(){
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    }
    //third: prepare request
    xhr.open("GET", url, true);
    //finally: send
    xhr.send();
}

function updateWeatherWithAjax(xhr) {
    //JSON.parse() will convert JSON-formatted string to a JS object
    var res = JSON.parse(xhr.responseText);
    console.log(res);
    //can use this object however we want! 
}

/*
    Fetch with POST requests
    first, get a token for Artsy api
*/

let artsyToken = '';
let artsyUrl = 'https://api.artsy.net/api/';

function getArtsyToken() {
    let clientId = '41225acd0944bc290c11';
    let clientSecret = 'b7d2cfec25c5c4c616e0ae6edf2007ae';
    fetch(artsyUrl+'tokens/xapp_token?client_id='+clientId+'&client_secret='+clientSecret, {method: "POST"})
    //define behavior for when the response returns
    .then((response) => {
        //return unwrapped promise object for the next chaining operation
        return response.json();
    })
        //utilize unwrapped promise a javascript object
    .then((data) => {
        console.log(data);
        artsyToken = data.token;
    })
        //what if there's a problem?
    .catch( (error) => {
        alert('oh no :(');
        console.log(error);
    });
}

let andyWarhol = {};

function getAndyWarhol(){
    fetch(artsyUrl+'artists/andy-warhol', {method: "GET", headers:{"X-Xapp-Token":artsyToken}})
    //define behavior for when the response returns
    .then((response) => {
        //return unwrapped promise object for the next chaining operation
        return response.json();
    })
        //utilize unwrapped promise a javascript object
    .then((data) => {
        console.log(data);
        andyWarhol = data;
    })
        //what if there's a problem?
    .catch( (error) => {
        alert('oh no :(');
        console.log(error);
    });
}

