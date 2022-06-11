const { Client, Intents, MessageEmbed, GUILD_WEBHOOKS } = require("discord.js");
const client = new Client({ intents: [Intents.FLAGS.GUILDS, Intents.FLAGS.GUILD_MESSAGES] });

//const sharp = require("")

const Config = require("../Config.json");

client.login(Config.TOKEN);

let webhook;
let channel;
let login = false;

client.on('ready', async () => {
  channel = client.guilds.cache.get(Config.ServerID).channels.cache.get(Config.ChannelID);
  const webhooks = await channel.fetchWebhooks();
  webhook = webhooks?.find((data) => data.token) ?? await channel.createWebhook(`${client.user.username}`);
  login = true;
  console.log(`login!!(${client.user.tag})`);
});

exports.bot = () => login;

//----------Player----------//
exports.login = (data) => {
  data.name = decodeURI(data.name);
  console.log(data);
  channel.send(`${data.name} さんがログインしました`);
};

exports.Chat = (data) => {
  data.name = decodeURI(data.name);
  data.text = decodeURI(data.text);
  console.log(data);

  webhook.send({
    content: data.text,
    username: data.name,
    avatarURL: `https://crafatar.com/avatars/${data.uuid}`
  })
};

exports.Quit = (data) => {
  data.name = decodeURI(data.name);
  console.log(data);
  channel.send(`${data.name} さんがログアウトしました`);
};

//----------Server----------//
exports.onEnable = () => {
  channel.send("サーバーが起動しました");
};

exports.onDisable = () => {
  channel.send("サーバーが停止しました");
};