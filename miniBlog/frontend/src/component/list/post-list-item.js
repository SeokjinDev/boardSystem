import React from "react";
import styled from "styled-components"

const Wrapper = styled.div`
    width: 100%;
    padding: 16px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    border: 1px solid grey;
    border-radius: 8px;
    cursor: pointer;
    background: white;
`;

const PostTitle = styled.p `
    font-size: 20px;
`;


function PostListItem(props) {
    const { post, onClick} = props;

    return (
        <Wrapper onClick={onClick}>
            <PostTitle>{post.title}</PostTitle>
        </Wrapper>
    )
}

export default PostListItem;