package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class TrelloMapperTestSuite {

    private final TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void mapToBoardsWithListsTest() {
        // Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "name", true);
        TrelloListDto trelloListDto1 = new TrelloListDto("2", "name2", false);

        List<TrelloListDto> listDtos = new ArrayList<>();
        Collections.addAll(listDtos, trelloListDto, trelloListDto1);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "nameTest", listDtos);
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        // When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtoList);
        // Then
        assertEquals(1, trelloBoards.size());
        assertEquals(2, trelloBoards.get(0).getLists().size());
        assertSame(trelloBoards.get(0).getClass(), TrelloBoard.class);
        assertSame(trelloBoards.get(0).getLists().get(0).getClass(), TrelloList.class);
    }
    @Test
    void mapToBoardsDtoWithListsTest() {
        // Given
        TrelloList trelloList = new TrelloList("1", "name", true);
        TrelloList trelloList1 = new TrelloList("2", "name2", false);

        List<TrelloList> lists = new ArrayList<>();
        Collections.addAll(lists, trelloList,trelloList1);

        TrelloBoard trelloBoard = new TrelloBoard("1", "testName", lists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        // When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoards);
        // Then
        assertEquals(1, trelloBoardDtoList.size());
        assertEquals(2, trelloBoardDtoList.get(0).getLists().size());
        assertEquals(trelloBoards.get(0).getLists().get(0).getId(), trelloBoardDtoList.get(0).getLists().get(0).getId());
        assertEquals(trelloBoards.get(0).getName(), trelloBoardDtoList.get(0).getName());
        assertSame(trelloBoardDtoList.get(0).getClass(), TrelloBoardDto.class);
        assertSame(trelloBoardDtoList.get(0).getLists().get(0).getClass(), TrelloListDto.class);
    }
    @Test
    void mapToCardDtoTest() {
        // Given
        TrelloCard trelloCard = new TrelloCard("name", "description","pos","1");
        // When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        // Then
        assertSame(trelloCardDto.getClass(), TrelloCardDto.class);
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
    }
    @Test
    void mapToCardTest() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos","1");
        // When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        // Then
        assertSame(trelloCard.getClass(), TrelloCard.class);
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }
}
