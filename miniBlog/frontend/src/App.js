import React from 'react';
import {
    BrowserRouter,
    Routes,
    Route
} from "react-router-dom"
import styled from "styled-components"
import MainPage from "./component/page/main-page"
import PostWritePage from "./component/page/post-write-page"
import PostDetailPage from './component/page/post-detail-page';

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 20px;
`;

const PostTitle = styled.h1` 
    font-size: 24px;
    margin-bottom: 20px;
`;

function App(props) {
    return (
        <Wrapper>
            <BrowserRouter>
                <PostTitle id='main-title-text'>mini blog</PostTitle>
                <Routes>
                    <Route index element={<MainPage/>} />
                    <Route path="post-write" element={<PostWritePage/>} />
                    <Route path="post/:postID" element={<PostDetailPage/>} />
                </Routes>
            </BrowserRouter>
        </Wrapper>
    )
  
}

export default App;
