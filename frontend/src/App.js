import React from 'react';
import Header from '../src/components/header/Header.jsx'
import Alphabet from '../src/components/alphabet/Alphabet.jsx'
import Genres from '../src/components/left-navigation/Genres.jsx'
import MainContent from '../src/components/main-content/MainContent.jsx'
import Footer from '../src/components/footer/Footer.jsx'
import './App.css';

function App() {
  return (
      <div className="wrapper">
        <Header/>
        <Alphabet/>
        <Genres/>
        <MainContent/>
        <Footer/>
      </div>
  );
}

export default App;
