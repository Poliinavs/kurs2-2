import React from 'react'
import ReactDOM from 'react-dom';
import App from './App';

//import { render } from 'react-dom'
// import { createStore } from 'redux'
// import { Provider } from 'react-redux'
// import App from './components/App'
// import rootReducer from './reducers'

//const store = createStore(rootReducer)

// render(
//   <Provider store={store}>
//     <App />
//   </Provider>,
//   document.getElementById('root')
// )

ReactDOM.render(
  <React.StrictMode>
    <App/>
  </React.StrictMode>,
  document.getElementById('root')
)

// const App=() =>{
//   return (
//     <div>

//     </div>

//   );

// };