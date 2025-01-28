package com.kickymaulana.belajarroomdatabase

import androidx.paging.PagingSource
import androidx.paging.PagingState

class PegawaiPagingSource(
    private val pegawaiService: PegawaiService
) : PagingSource<Int, Pegawai>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pegawai> {
        val page = params.key ?: 1 // Halaman pertama jika tidak ada kunci
        return try {
            val response = pegawaiService.getUsers(page, params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pegawai>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1) ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}