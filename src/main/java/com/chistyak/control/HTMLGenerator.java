package com.chistyak.control;

import static j2html.TagCreator.*;

/**
 * Created by Krav-Ig on 26.02.2017.
 */
public class HTMLGenerator {


    public static String insertion(String initial, String toInsert){
        String[] arr = initial.split("<div id=\"page_wall_posts\">");
        return arr[0] + "<div id=\"page_wall_posts\">" + toInsert + arr[1];
    }

    public static String createBasic(){
        return html().with(
                head().with(
                        title().withText("username"),
                        link().withRel("stylesheet").
                                withType("text/css").
                                withHref("https://vk.com/css/al/common.css?3139011733"),
                        link().withRel("stylesheet").
                                withType("text/css").
                                withHref("https://vk.com/css/al/ui_common.css?1997027190"),
                        link().withRel("stylesheet").
                                withType("text/css").
                                withHref("https://vk.com/css/al/page.css?926066209"),
                        link().withRel("stylesheet").
                                withType("text/css").
                                withHref("https://vk.com/css/al/post.css?1944218596")
                        ),
                body().with(
                        div().withId("page_wrap").
                                withClass("scroll_fix_wrap _page_wrap").
                                with(
                                        div().with(
                                                div().withClass("scroll_fix").
                                                        with(
                                                                div().withId("page_body").
                                                                        with(
                                                                                div().withId("wrap3").
                                                                                        with(
                                                                                                div().withId("wrap2").
                                                                                                        with(
                                                                                                                div().withId("wrap1").
                                                                                                                        with(
                                                                                                                                div().withId("content").
                                                                                                                                        with(
                                                                                                                                                div().withId("content").
                                                                                                                                                        with(
                                                                                                                                                                div().withId("profile").
                                                                                                                                                                        with(
                                                                                                                                                                                div().withClass("wide_column_right").
                                                                                                                                                                                        with(
                                                                                                                                                                                                div().withClass("wide_column_wrap").
                                                                                                                                                                                                        with(
                                                                                                                                                                                                                div().withId("wide_column").
                                                                                                                                                                                                                        with(
                                                                                                                                                                                                                                div().withClass("wall_module").
                                                                                                                                                                                                                                        withId("profile_wall").
                                                                                                                                                                                                                                        with(
                                                                                                                                                                                                                                                div().withId("page_wall_posts")
                                                                                                                                                                                                                                        )
                                                                                                                                                                                                                        )
                                                                                                                                                                                                        )
                                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                        )
                                                                                                                                        )
                                                                                                                        )
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                                )
                )
        ).render();
    }
}
