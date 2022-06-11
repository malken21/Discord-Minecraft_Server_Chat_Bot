const http = require('http');
const port = 3210;

const discord_bot = require("./discord/discord_bot.js")

const Server = http.createServer(function (req, res) {
  if (req.method === 'POST') {
    res.setHeader("content-type", "application/json;charset=utf-8");
    let data = '';
    req.on('data', chunk => { data += chunk })
      .on('end', function () {
        res.end("ok");
        data = JSON.parse(data);
        if (discord_bot.bot() === false) return;
        switch (data.type) {
          case 0:
            discord_bot.login(data);
            break;
          case 1:
            discord_bot.Chat(data);
            break;
          case 2:
            discord_bot.Quit(data);
            break;
          case 1000:
            discord_bot.onEnable();
            break;
          case 1001:
            discord_bot.onDisable();
            break;
        }
      })
  }
})
Server.listen(port);
console.log(`port : ${port}`)