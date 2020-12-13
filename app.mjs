import express from 'express';

import connectToDatabase from './helpers.mjs'

const app = express();

app.get('/', (req, res) => {
  res.send('<h2>Hi there! <br> The deployment works again! <br> And Now its starting with a webhook!</h2>');
});

await connectToDatabase();

app.listen(3000);
