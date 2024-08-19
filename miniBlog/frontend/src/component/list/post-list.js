import React from "react";
import styled from "styled-components"
import PostListItem from "./post-list-item";

const Wrapper = styled.div `
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    :hover {
        background: lightgrey;
    }
`;

function PostList(props) {
    const { posts, onClickItem} = props;
    return (
        <Wrapper>
            {posts.map((post, index) => {
                return (
                    <PostListItem
                        key={post.id}
                        post={post}
                        onClick={() => {
                            onClickItem(post);
                        }}
                    />
                );
            })}
        </Wrapper>
    )
}

export default PostList;