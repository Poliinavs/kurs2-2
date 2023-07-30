import React from 'react';
import '../style/App.css';
import Menu from './menu';
import MainInform from './MainInform';
import MainMenu from './MainMenu';

const App = () => {

  return (
    <div className='app'>
      <MainMenu />
      <MainInform />
    </div>
  );
};

export default App;