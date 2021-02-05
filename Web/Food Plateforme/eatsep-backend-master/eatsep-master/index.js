import 'regenerator-runtime/runtime'

import app from './app'

const port = 8002

const server = app.listen(port, () => {
  const port = server.address().port
  console.log('Server listening on port ' + port + '...')
})
