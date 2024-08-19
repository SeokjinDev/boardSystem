import React from "react";
import styled from "styled-components"

const Wrapper = styled.div `
    width: 95%;
    padding: 8px 16px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    border: 1px solid grey;
    border-radius: 8px;
    cursor: pointer;
    background: white;
`;

const ContentText = styled.p `
    font-size: 16px;
    white-space: pre-wrap;
`;

function CommentListItem(props) {
    const { comment } = props;
    return (
        <Wrapper>
            <ContentText>{comment.content}</ContentText>
        </Wrapper>
    )
}

export default CommentListItem;