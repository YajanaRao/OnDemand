var express = require('express');
var morgran = require('morgan');
var path = require('path');
var pool = require('pg').pool;
var crypto = require('crypto');

var app = express();
app.use(morgan('combined'));

app.get('/', function(req,res){
	res.sendFile(path.join(_dirname,'ui','hasing.html'));
});

function hash (input){
var hashed = crypto.pbkdf2Sync(input,salt,1000,612,'sha512');
return hashed.toString('hex');

app.get('/hash/:input', function(req,res){
	var hashedString = hash(req.params.input, 'yajana');
});

var pool = new Pool(config);
app.get('/test-db',function(req,res){
	pool.query('SELECT * FROM test', function(err,result){
		if(err){
			res.status(500).send(err.toString());
		} else{
			res.send(JSON.stringify(result.rows));
		}
	});
});