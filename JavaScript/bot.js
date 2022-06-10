const { Client, Intents, MessageEmbed } = require("discord.js");
const client = new Client({ intents: [Intents.FLAGS.GUILDS, Intents.FLAGS.GUILD_MESSAGES] });

const http = require('http');

const port = 3210;

http.createServer(function (req, res) {
  if (req.method === 'POST') {

    res.setHeader("content-type", "application/json;charset=utf-8");

    let data = '';

    //POSTデータを受けとる
    req.on('data', chunk => { data += chunk })
      .on('end', function () {
        res.end("ok");

        data = JSON.parse(data)
        data.name = decodeURI(data.name);
        data.text = decodeURI(data.text);
        console.log(data);

      })

  }
}).listen(port);