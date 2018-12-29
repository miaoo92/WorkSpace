package com.segmentfault.spring.boot.lesson9;

import com.segmentfault.spring.boot.domain.Track;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/25
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> together = Stream.of(asList(1,2), asList(3,4))
                .flatMap(number -> number.stream())
                .collect(Collectors.toList());
        assertEquals(asList(1,2,3,4),together);

        List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
        System.out.println(shortTrack);


        int count = Stream.of(1,2,3,4,5).reduce(0,(x,y) -> x+y);
        System.out.println(count);
    }
}
