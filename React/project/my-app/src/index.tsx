// import React from 'react'
// import ReactDOM from 'react-dom';
// import App from './components/App';
// import rootReducer from './reducers'

// import { render } from 'react-dom'
// import { createStore } from 'redux'
// import { Provider } from 'react-redux'

// //const store = createStore(rootReducer)

// ReactDOM.render(
//   <React.StrictMode>
//     <App/>
//   </React.StrictMode>,
//   document.getElementById('root')
// )

import React from 'react'
import { render } from 'react-dom'
import { createStore } from 'redux'
import { Provider } from 'react-redux'
import App from './components/App'
import rootReducer from './reducers'
import inform from './inform'





const store = createStore(rootReducer)



function AddJob(store:any){
  // Использование
  store.dispatch(
    inform[0]
  );
  store.dispatch(
    inform[1]
  );
  store.dispatch(
    inform[2]
  );
  store.dispatch(
    inform[3]
  );
  

    
    // [{ id: 1, text: 'Понять насколько redux прост', completed: false }]
  }

  AddJob(store);
render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById('root')
)
