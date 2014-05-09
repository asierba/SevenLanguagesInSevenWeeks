#!/usr/bin/env ruby

numbers = (1..16).to_a

numbers.each_slice(4) { |r| print " #{r} \n" }
