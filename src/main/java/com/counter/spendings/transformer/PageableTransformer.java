package com.counter.spendings.transformer;

import com.counter.spendings.web.request.PageableRequest;
import com.counter.spendings.web.response.PagedResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Created by Sashko on 8/29/16.
 */
public class PageableTransformer {

    public static Pageable toPageable(PageableRequest pagedRequest) {
        return new org.springframework.data.domain.PageRequest(
                pagedRequest.getPageNumber() - 1,
                pagedRequest.getPageSize(),
                getSort(pagedRequest.getSortField(), pagedRequest.isAsc())
        );
    }

    public static <T> PagedResult toPagedResult(Page<T> pageableResult, Function<? super T, ?> function) {
        return new PagedResult<>(
                pageableResult.getContent().stream().map(function).collect(toList()),
                pageableResult.getNumber(),
                pageableResult.getSize(),
                pageableResult.getTotalElements()
        );
    }

    private static Sort getSort(String draftSortingField, boolean isAsc) {
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        String sortField = StringUtils.isEmpty(draftSortingField) ? "id" : draftSortingField;
        return new Sort(new Sort.Order(direction, sortField));
    }

}
