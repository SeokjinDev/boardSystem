import React from "react";
import { useNavigate } from "react-router-dom"
import styled from "styled-components"
import PostList from "../list/post-list"
import postsData from "../../test-data/postsData.json"

const Wrapper = styled.div`
    padding: 16px;
    width: 90%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

const Container = styled.div`
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    gap: 16px;
`;

const Button = styled.button`
    margin: 0 auto;
    width: 90%;
    padding: 12px 16px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background-color: #007bff;
    color: white;
    cursor: pointer;
    transition: background-color 0.3s;

    &:hover {
        background-color: #0056b3;
    }
`;

function MainPage() {
    const navigate = useNavigate();
    return (
        <Wrapper>
            <Container>
                <Button
                    title="Write"
                    onClick={() => {
                        navigate("/post-write");
                    }}
                >
                    Write
                </Button>
                <PostList
                    posts={postsData.posts}
                    onClickItem={(post) => {
                        navigate(`/post/${post.id}`);
                    }}
                />
            </Container>
        </Wrapper>
    )
}

export default MainPage;