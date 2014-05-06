#!/usr/bin/perl

# File Name: haiku_epic.cgi

# Description: Allows user to submit lines that will be appended to a file and displayed on the same page.

use CGI qw(:standard);

sub print_stanza
{
        open(DISPLAY, "<haiku_epic_data.dat") || die "Unable to open DISPLAY file handle";
                while(<DISPLAY>)
                       {
                        my @stanza = split(/:/,$_);

        sub pick_color
                {
                        my $rand_num;
                        my $rand_let;
                        my $choose_num;# 1 -> num use $rand_num, 0 -> use $rand_let

                         $t_color = "#";
                         $b_color = "#";

                        for($n = 0; $n < 6; $n++)
                                {
                                        my $rand_num = int(rand(10)) + 48;
                                        my $rand_let = int(rand(6)) + 65;
                                        my $choose_num = int(rand(2));

                                        if($choose_num)
                                                {$b_color = $b_color.chr($rand_num);}
                                        else
                                                {$b_color = $b_color.chr($rand_let);}
                                }
                        for($m = 0; $m < 6; $m++)
                                                                                                                                                       1,1           Top

