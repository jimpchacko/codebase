# Sample App to deploy to Heroku

## How to use

1. Create an account on <https://heroku.com>
2. Install Heroku command-line tools
2. Create a new project in heroku (say test-project-myname)
3. Clone a sample repository

    $ git clone https://gitlab.com/anandology/heroku-sample-app

4. Add heroku as remote to your git repo

    $  heroku git:remote -a test-project-myname

5. Deploy!

    $ git push heroku master

your website will be live at:

    https://test-project-myname.herokuapp.com

When you make any changes, do `git commit` and then run `git push heroku
master` to deploy.
